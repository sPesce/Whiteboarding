function squareDigits(num){
  const reducer = (memo,char) => {
    const digit = parseInt(char);
    return (memo + (digit * digit).toString());
  } 

  return parseInt([...num.toString()].reduce(reducer,""));  
}

console.log(squareDigits(99));