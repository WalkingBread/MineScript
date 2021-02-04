function Array3D(dim1, dim2, dim3) {
    var array = [];
    for(var x = 0; x < dim1; x++) {
        array.push([]);
        for(var y = 0; y < dim2; y++) {
            array[x].push([]);
            for(var z = 0; z < dim3; z++) {
                array[x][y].push(null);
            }
        }
    }
    return array;
}