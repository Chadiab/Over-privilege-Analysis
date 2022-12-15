import frida, sys

##TODO
## sepeate JS Files
## Auto-Run selected process if not running on Emulator

def on_message(message, data):
    if message['type'] == 'send':
        print("[*] {0}".format(message['payload']))
        sys.stdout.flush()
    else:
        print(message)
        sys.stdout.flush()

# "rock_paper_scissors"

# --- Get Args
js_file= sys.argv[1] +".js"
process_name = sys.argv[-1]
# ---- Load Js Code
with open(js_file,"r","utf-8") as f:
    jscode=f.readlines().strip()

process = frida.get_usb_device().attach(process_name)
script = process.create_script(jscode)
script.on('message', on_message)
print('[*] Running CTF')
script.load()
sys.stdin.read()


