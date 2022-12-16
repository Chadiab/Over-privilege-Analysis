##TODO
## sepeate JS Files
## Auto-Run selected process if not running on Emulator



import frida, sys

def on_message(message, data):
    if message['type'] == 'send':
        print("[*] {0}".format(message['payload']))
        sys.stdout.flush()
    else:
        print(message)
        sys.stdout.flush()


jscode = """
Java.perform(() => {
  // Function to hook is defined here
  const MainActivity = Java.use('com.example.seccon2015.rock_paper_scissors.MainActivity');

  // Whenever button is clicked
  const onClick = MainActivity.onClick;
  onClick.implementation = function (v) {
    // Show a message to know that the function got called
    send('onClick');

    // Call the original onClick handler
    onClick.call(this, v);

    // Set our values after running the original onClick handler
    this.m.value = 0;
    this.n.value = 1;
    this.cnt.value = 999;

    // Log to the console that it's done, and we should have the flag!
    console.log('Done:' + JSON.stringify(this.cnt));
  };
});
"""
# "rock_paper_scissors"
process_name= sys.argv[-1]
process = frida.get_usb_device().attach(process_name)
script = process.create_script(jscode)
script.on('message', on_message)
print('[*] Running CTF')
script.load()
sys.stdin.read()



##TODO
## Auto-run proces on emulator
# com.example.seccon2015.rock_paper_scissors/.MainActivity
# am start -n com.package.name/com.package.name.ActivityName
# -> adb shell am start -n com.example.seccon2015.rock_paper_scissors/.MainActivityy