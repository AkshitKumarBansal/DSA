/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    let result = [];
    for(let i = 0; i < arr.length; i++) {
        let val = (fn(arr[i], i));
        result.push(val);
    }
    return result;
};