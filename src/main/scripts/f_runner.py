import frida, sys,os


def on_message(message, data):
    if message['type'] == 'send':
        print("[*] {0}".format(message['payload']))
        sys.stdout.flush()
    else:
        print(message)
        sys.stdout.flush()


# --- Get Args
js_file = sys.argv[1]
process_name = sys.argv[-1]
# ---- Pre-Load Js Code
print(js_file)
with open(js_file,'r',encoding="utf-8") as f:
    jscode = f.read()

print(jscode)
process = frida.get_usb_device().attach(process_name)
script = process.create_script(jscode)
script.on('message', on_message)
script.load()
sys.stdin.read()
