import { useState } from 'react';
import './App.css';

function App() {
  console.log("App component mounted");

  const [typeText, setTypeText] = useState("hola");
  const [inputText, setInputText] = useState("");
  const [curWordPos, setCurWordPos] = useState(0); // State for curWordPos

  // Simulated API data
  const typeData = [
    { "word": "hola", "def": ["hello", "hey"] },
    { "word": "buenos", "def": ["good"] }
  ];

  const currWordDef = typeData[curWordPos]?.def || [];

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
      setTypeText(typeData[curWordPos + 1].word); // Move to next word
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
          <p>{typeText}</p>
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
