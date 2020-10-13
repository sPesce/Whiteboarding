function findOutlier(integers){
  let mod = integers.slice(0,3).reduce((acc,x) => acc + Math.abs(x) % 2,0) < 2 ? 1 : 0 
  return integers.find(int => Math.abs(int) % 2 === mod);
}