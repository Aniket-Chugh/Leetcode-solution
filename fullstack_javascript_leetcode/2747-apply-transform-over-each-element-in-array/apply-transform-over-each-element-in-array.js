var map = function(arr, fn) {
    const result = [];
const length= arr.length;
    for (let i = 0; i < arr.length; i++) {
        
        result.push( fn(arr[i], i) );  // js ko  ferek nhi padta kitne bhi para daaldo zerorat hogi use kerlega nhi toh ignore ker dega 
    }

    return result;
};
