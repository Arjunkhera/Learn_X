// Game values
let min = 1,
    max = 10,
    winningNum = getRandomNumber(min, max),
    guessesLeft = 3;

// UI elements
const game = document.getElementById('game'),
    minNum = document.querySelector('.min-num'),
    maxNum = document.querySelector('.max-num'),
    guessBtn = document.querySelector('#guess-btn'),
    guessInput = document.querySelector('#guess-input'),
    message = document.querySelector('.message');

// Assign min and max
minNum.textContent = min;
maxNum.textContent = max;

// Play Again event listener
game.addEventListener('mousedown', e => {
    if(e.target.className === 'play-again') {
        console.log('play-again')
        window.location.reload();
    }
});

// Listen for guess
guessBtn.addEventListener('click', e => {
    let guess = parseInt(guessInput.value);

    // Validate
    if(isNaN(guess) || guess < min || guess > max) {
        setMessage(`Please enter a number between ${min} and ${max}`, 'red');
        return;
    }

    // Check if won
    if(guess === winningNum) {
        gameOver(true, `${winningNum} is correct, YOU WIN!`);
    } else {
        // Wrong number
        guessesLeft -= 1;

        if (guessesLeft === 0) {
            gameOver(false, `Game Over, you lost. The correct number was ${winningNum}`);
        } else {
            // Change border color
            guessInput.style.borderColor = 'red';

            // Clear input
            guessInput.value = '';

            // Game over - wrong answer
            setMessage(`${guess} is not correct, ${guessesLeft} guesses left`, 'red');
        }
    }
})

function gameOver(won, msg) {
    let color = won === true ? 'green':'red';

    // Disable input
    guessInput.disabled = true;
    // Change border color
    guessInput.style.borderColor = color;
    // Set Message
    setMessage(msg, color); 
    
    // Play Again ?
    guessBtn.value = 'Play Again';
    guessBtn.className += 'play-again';
}

// Get winning number
function getRandomNumber(min, max) {
    const win = Math.floor(Math.random()*(max-min+1)+min);
    // console.log(win);
    return win;
}

function setMessage(msg, color) {
    message.style.color = color;
    message.textContent = msg;
}

