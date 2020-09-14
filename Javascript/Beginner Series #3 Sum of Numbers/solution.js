function getSum(a, b) {
  let sum = 0;
  let [x, y] = [Math.max(a, b), Math.min(a, b)]

  for (y; y <= x; y++)
    sum += y;

  return sum;
}

//Given two integers a and b, which can be positive or negative,
//find the sum of all the numbers between including them too 
//and return it. If the two numbers are equal return a or b.

//Note: a and b are not ordered!
