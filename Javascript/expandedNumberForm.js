function expandedForm(num) {
  const numStrArr = [...num.toString()]
  return numStrArr.reduce((acc,digit,i) => {
    digit !== '0' && acc.push(digit + '0'.repeat(numStrArr.length - 1 - i));
    return acc
  },[]).join(' + ');  
}