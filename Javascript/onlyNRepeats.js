function deleteNth(arr,n){
  let hTable = {};
  //create or increment hash value, filter out if its above n
  return arr.filter((num) => {
    return (hTable[num] = !!hTable[num] ? hTable[num] += 1 : 1) <= n;
  });
}