function EventObserver() {
    constructor() {
        this.observers = [];
    }
}

EventObserver.prototype = {
    subscribe: function(fn) {
        this.observers.push(fn);
        console.log(`You are now subscribe to ${fn.name}`);
    },
    unsubscribe: function(fn) {
        this.observers = this.observers.filter(function(item) {
            if(item !== fn) {
                return item;
            }
        });
    },
    fire: function() {
        this.observers.forEach((item) => {
            item.call();
        })
    }
}

const click = new EventObserver();

// Event Listeners
document.querySelector('.sub-ms').addEventListener('click', function(evt) {
    click.subscribe(getCurMilliseconds);
});
document.querySelector('.unsub-ms').addEventListener('click', function(evt) {
    click.unsubscribe(getCurMilliseconds);
});
document.querySelector('.fire').addEventListener('click', function(evt) {
    click.fire();
});


// Click Handler
const getCurMilliseconds = function() {
    console.log(`Current Milliseconds: ${new Date().getMilliseconds()}`);
}

