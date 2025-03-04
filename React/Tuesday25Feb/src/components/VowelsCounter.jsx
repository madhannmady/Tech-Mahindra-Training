const VowelsCounter = (props) => {
  const countVowels = (str) => {
    const vowels = ["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"];
    let vowelCount = 0;
    for (let char of str) {
      if (vowels.includes(char)) {
        vowelCount++;
      }
    }
    return vowelCount;
  };

  const totalVowels = countVowels(props.text);

  return (
    <div>
      <p>----------------------------------------</p>
      <p>String: "{props.text}"</p>
      <p>Number of vowels: {totalVowels}</p>
    </div>
  );
};

export default VowelsCounter;
