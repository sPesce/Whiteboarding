function getSum(a, b) {
  let sum = 0;
  let [x, y] = [Math.max(a, b), Math.min(a, b)]

  for (y; y <= x; y++)
    sum += y;

  return sum;
}