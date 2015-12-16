// lineCt.js
// Paul Krishnamurthy 2015
// Node.js script to count lines of code

var fs        = require("fs");
var count     = 0;
var files     = fs.readdirSync(".");
var toExclude = [
	".git",
	".gitignore",
	"README.md",
	"lineCt.js",
	"resources"
]

/**
 * @param {String} file Path and name of file
 */
function countLines(file) {
	// Use fs synchronously
	var text = fs.readFileSync(file, "utf8")
	return text.split("\n").length;
}

for (var file = 0; file < files.length; file++) {
	if (!(toExclude.indexOf(files[file]) > -1)) {
		if (!(files[file].slice(files[file].length - 5, files[file].length) === "class")) {
			count += countLines(files[file]);
		}
	}	
}

console.log("Total Lines: " + count);
