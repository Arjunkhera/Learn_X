class Person {
    constructor(firstName, lastName, dob) {
        this.firstName = firstName;
        this.lastName = lastName;        
        this.birthday = new Date(dob);
    }

    greeting() {
        return `Hello ${this.firstName}  ${this.lastName}`;
    }

    calculateAge() {
        const diff = Date.now() - this.birthday.getTime();
        const ageDate = new Date(diff);
        return Math.abs(ageDate.getUTCFullYear() - 1970);
    }

    getsMarried(newLastName) {
        this.lastName = newLastName;
    }

    static addNumbers(x, y) {
        return x + y;
    }
}

const mary = new Person('Mary', 'Williams', '11-13-1990');


console.log(mary);

console.log(mary.calculateAge())
mary.getsMarried('Thompson');

console.log(mary);

// Need to use class name since method is static
console.log(Person.addNumbers(2,3));