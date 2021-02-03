const Bukkit = org.bukkit.Bukkit;
const Location = org.bukkit.Location;
const Material = org.bukkit.Material;
const Player = org.bukkit.entity.Player;

const server = Bukkit.getServer();

const OVERWORLD = server.getWorlds()[0];
const NETHER = server.getWorlds()[1];
const END = server.getWorlds()[2];

var clipboard = [];


function setBlock(location, block) {
    location.getBlock().setType(block);
}

function modify_area(location1, location2, callback) {
    var x1 = location1.getX();
    var y1 = location1.getY();
    var z1 = location1.getZ();

    var x2 = location2.getX();
    var y2 = location2.getY();
    var z2 = location2.getZ();

    if(location1.getX() > location2.getX()) {
        x1 = location2.getX();
        x2 = location1.getX();
    }
    if(location1.getY() > location2.getY()) {
        y1 = location2.getY();
        y2 = location1.getY();
    }
    if(location1.getZ() > location2.getZ()) {
        z1 = location2.getZ();
        z2 = location1.getZ();
    }

    for(var x = x1; x < x2; x++) {
        for(var y = y1; y < y2; y++) {
            for(var z = z1; z < z2; z++) {
                var location = new Location(location1.getWorld(), x, y, z);
                callback(location);
            }
        }
    }
}

function fill(location1, location2, block) {
    function callback(location) {
        setBlock(location, block);
    }

    modify_area(location1, location2, callback);
}

function copy(location1, location2) {
    var blocks = []

    function callback(location) {
        var block = location.getBlock();
        blocks.push(block.type);
    }

    modify_area(location1, location2, callback);
    clipboard = blocks;
}