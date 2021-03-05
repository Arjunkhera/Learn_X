var g = 10;

console.log(result); 

function add(x,y) {
    console.log(this); 
    return x + y;
}

var result = add(4,5);