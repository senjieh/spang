import { useState } from 'react';
import './App.css';

function App() {
  const [inputText, setInputText] = useState("");
  const [curWordPos, setCurWordPos] = useState(0);

  // Simulated API data
  const typeData = [
    { "word": "hola", "def": ["hello", "hey"] },
    { "word": "buenos", "def": ["good"] }
  ];

  // Definition check
  const currWordDef = typeData[curWordPos]?.def || [];

  // Iterate to the next word
  const iterateNextWord = () => {
    setCurWordPos((prevPos) => prevPos + 1);
  };

  const checkCurrentWord = (currInputWord : string) => {
    if (currWordDef.includes(currInputWord)) {

      iterateNextWord();

      if (curWordPos >= typeData.length - 1) {
        setInputText(currInputWord);
        setInputText("");
        return;
      }
      setInputText("");
    } else {
      setInputText(currInputWord);
    }
  };

  return (
    <>
      {curWordPos >= typeData.length? (
        <div>
          <p>Congrats!</p>
        </div>
      ) : (
        <div>
          <div className='text-display'>
            {typeData.map((word, index) => {
              if(index == curWordPos ) {
                return <p key={index} className='curWord'>{word.word}</p>
              }
              else{
                return <p key={index} className='gWord'>{word.word}</p>
              }
            })}
          </div>
          <input
            value={inputText}
            onChange={(e) => checkCurrentWord(e.target.value)}
            type="text"
            autoCorrect="off"
            autoCapitalize="off"
          />
        </div>
      )}
    </>
  );
}

export default App;
