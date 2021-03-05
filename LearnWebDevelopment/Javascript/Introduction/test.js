a = 1;

var b = 2;

cFunc = function(e) {
  var c = 10;
  var d = 15;
  
  console.log("cfunc() c: " + c);
  console.log("cfunc() a: " + a); 
  
  function dFunc() {
    var f = 5;
    console.log("dfunc() f: " + f)
    console.log("dfunc() c: " + c);
    console.log("dfunc() a: " + a); 
    c += 12;
  }

  dFunc();
  console.log("cfunc() c: " + c);

}

cFunc(10);