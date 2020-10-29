function getPINs(observed) {
  const digits = observed.split("");
  
}
// [int,int] => int || null
const coordToPin = (xyCoords) => {
  const pinMap = {
    [1,1]: 1, [2,1]: 2, [3,1]: 3,
    [1,2]: 4, [2,2]: 5, [3,2]: 6,
    [1,3]: 7, [2,3]: 8, [3,3]: 9,
              [2,4]: 0
  }
  const pinNum = pinMap[[...xyCoords]];
  
  return pinNum === undefined ? null : pinNum;
}