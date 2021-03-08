str = "This is 1, and this is 2, and now again 1";
arr = [1,2,3,4,5,6,7,8,9,10];

let val;

// Split : works only on arrays
val = str.split(',');
val = str.split(' ');
// split all character
val = str.split('');
// I just need first five
val = str.split('', 5)

// Slice : get subarray or substring
val = str.slice(2);
val = arr.slice(-4,4);

// Splice : the swiss knife for array operations

// removing elements
// all after given index
val = arr.splice(-2);
// 2 after 2
val = arr.splice(2,2);

// adding elements
// index, number of elements to remove, the elements to add
val = arr.splice(arr.length, 2, 9, 10);
// replacing 5,6 with 3,4
val = arr.splice(2, 2, 3, 4);
val = arr

console.log(val);