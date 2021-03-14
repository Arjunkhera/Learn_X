function namesIterator(names) {
    let index = 0;

    return {
        next: function() {
            return index < names.length ? 
            { value: names[index++], done:false } :
            { done:true }
        },
        getIndex: function() {
            return index;
        }
    }
}

namesArray = ['Arjun', 'Neishka', 'Aayush'];
const fnIteratorOne = namesIterator(namesArray);

console.log('Function Iterator First');
console.log(fnIteratorOne.next());
console.log(fnIteratorOne.next());
console.log(fnIteratorOne.getIndex());
console.log(fnIteratorOne);

console.log('Function Iterator Second');
const fnIteratorSecond = namesIterator(namesArray);
console.log(fnIteratorSecond.next());
console.log(fnIteratorSecond.next());
console.log(fnIteratorSecond.getIndex());

const arrowIterator = (names) => {
    let index = 0;

    return {
        next: () => {
            return index < names.length ? 
            { value: names[index++], done:false } :
            { done:true }
        },
        getIndex: () => {
            return index;
        }
    }
}

console.log('Arrow Iterator First');
const arrowIteratorFirst = arrowIterator(namesArray);
console.log(arrowIteratorFirst.next());
console.log(arrowIteratorFirst.next());
console.log(arrowIteratorFirst.getIndex());

console.log('Arrow Iterator Second');
const arrowIteratorSecond = arrowIterator(namesArray);
console.log(arrowIteratorSecond.next());
console.log(arrowIteratorSecond.next());
console.log(arrowIteratorSecond.getIndex());
