var createCounter = function(init) {
    let count = init; // keep track of current number

    const increment = () => {
        count++;
        return count;
    }

    const decrement = () => {
        count--;
        return count;
    }

    const reset = () => {
        count = init;
        return count;
    }

    return { increment, decrement, reset };
};

const counter = createCounter(5);

console.log(counter.increment()); // 6
console.log(counter.decrement()); // 5
console.log(counter.reset());     // 5
