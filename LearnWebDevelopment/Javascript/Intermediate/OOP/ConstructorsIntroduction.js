// this in the global scope always refers to window
console.log(this);

// Person Constructor
function Person(name, dob) {
    this.name = name;
    this.birthday = new Date(dob);

    this.calculateAge = () => {
        const diff = Date.now() - this.birthday.getTime();
        const ageDate = new Date(diff);

        return Math.abs(ageDate.getUTCFullYear() - 1970);
    }

    // will log the current object, which is Person here
    console.log(this);
}

const brad = new Person('Brad', '9-10-1996');
val = brad;
val = console.log(brad.calculateAge());

console.log(val); 

