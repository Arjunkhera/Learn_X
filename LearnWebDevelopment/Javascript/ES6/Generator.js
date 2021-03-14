function* getNames() {
    yield "Arjun";
    yield "Neishka";
}

const names = getNames();
console.log(names.next().value);
console.log(names.next().value);
console.log(names.next().done);

function* getId() {
    let index = 1;

    while(true) {
        yield index++;
    }
}

const id = getId();
console.log(id.next().value);
console.log(id.next().value);
console.log(id.next().done);