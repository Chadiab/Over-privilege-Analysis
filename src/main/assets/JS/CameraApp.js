Java.perform(() => {
    // Function to hook is defined here
    const MainActivity = Java.use('com.example.seccon2015.rock_paper_scissors.MainActivity');

    // Whenever button is clicked
    const PermCheck = MainActivity.allPermissionGranted;
    PermCheck.implementation = function (v) {
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