//only I allowed in subtractive form
//this passes the tests on code wars
function solution(roman){
  
  const romanArr = [...roman]  
  const romanMap = {
    M:  1000,
    D:  500,
    C:  100,
    L:  50,
    X:  10,
    V:  5,
    I:  romanArr[romanArr.length -1] === 'V' ? -1 : 1,
  }  

  return romanArr.reduce((val,numR) => val + romanMap[numR],0);
}
//any smaller number before a larger number will be subracted
function solution2(roman){
  const romanArr = [...roman].reverse();  
    const romanMap = {
      M:  1000,
      D:  500,
      C:  100,
      L:  50,
      X:  10,
      V:  5,
      I:  1,
    }
  
    let highest = romanMap[romanArr[0]];
    
    return romanArr.reduce((acc,numR) => {
      let current = romanMap[numR];
      
      if(current >= highest) highest = current;
      else current *= -1;

      return acc + current;
    },0);
  }
