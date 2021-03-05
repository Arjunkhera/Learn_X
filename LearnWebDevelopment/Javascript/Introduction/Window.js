// WINDOW methods / objects / properties

// alert
alert("alert");

// prompt
const input = prompt();
alert(input);

// confirm
if (confirm("are you sure")) {
    console.log('YES');
} else {
    console.log('NO');
}


let val;
// outer height and width : looks at size of browser window
val = window.outerHeight;
val = window.outerWidth;

// inner height and width : looks at size of viewing area
val = window.innerHeight;
val = window.innerWidth;

// scroll points
val = window.scrollY
val = window.scrollX;

// location object
val = window.location;
val = window.location.hostname;
val = window.location.port;
val = window.location.href;
val = window.location.search;


// redirect
window.location.href = 'http://google.com';
// reload
window.location.reload();
// history object
window.history.go(-2);

// navigator object
val = window.navigator;
val = window.navigator.appName;
val = window.navigator.appVersion;
val = window.navigator.userAgent;
val = window.navigator.platform;
val = window.navigator.vendor;

console.log(val);