import requests
url = 'http://localhost:8080/doLogin'

headers = {
    'Content-Type': 'application/x-www-form-urlencoded',
}


payloads = [ 
    "admin",
    "'"
    "'+--",
    "admin'+or+1=1+--"
]

exit_code = 0
for payload in payloads:
    data = f"uid={payload}&passw=test&btnSubmit=Login"
    response = requests.post(url, headers=headers, data=data, allow_redirects=False)

    if response.status_code == 302:
        if 'Set-Cookie' in response.headers and 'AltoroAccounts' in response.headers['Set-Cookie']:
            
            print(f"[!] uid={payload},Se detectó inyección SQL en el login.")
            print(f"\t Set-Cookie recibida: {response.headers['Set-Cookie']}")
            exit_code += 1
        else:
            print(f"[*] Uid = {payload}, Se recibió un {response.status_code}, pero no se encontró la cookie AltoroAccounts.")
            exit_code += 0
    else:
        print(f"[*] Uid = {payload}, No se detectó el redireccionamiento {response.status_code} o el login falló.")
        exit_code += 0

if exit_code == 1:
    exit(1)

# print(response.status_code)
# print(response.headers)
