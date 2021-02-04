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

function get_area(location1, location2) {
    if(location1.getWorld() != location2.getWorld()) {
        return;
    }
    world = location1.getWorld();

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

    var area = [];
    for(var x = x1; x < x2; x++) {
        area.push([]);
        for(var y = y1; y < y2; y++) {
            area[x - x1].push([]);
            for(var z = z1; z < z2; z++) {
                var location = new Location(world, x, y, z);
                area[x - x1][y - y1].push(location);
            }
        }
    }
    return area;
}

function fill(location1, location2, block) {
    var area = get_area(location1, location2);

    for(var x = 0; x < area.length; x++) {
        for(var y = 0; y < area[0].length; y++) {
            for(var z = 0; z < area[0][0].length; z++) {
                var location = area[x][y][z];
                setBlock(location, block);
            }
        }
    }
}

function copy(location1, location2) {
    var area = get_area(location1, location2);
    //copy to clipboard
}

function paste(location) {

}