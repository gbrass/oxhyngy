function showPane(pNumPanel) {
    for (x = 1; x <= 3; x++) {
        if (pNumPanel == x) {
            alert("#panel" + x);
            alert($("#panel" + x).id);
            $("#panel" + x).hidden = false;
            //document.getElementById("panel" + x).hidden = false;
        } else {
            $("#panel" + x).hidden = true;
        }
    }
}

function displayMenu() {
	document.write('<nav class="navbar navbar-inverse">');
	document.write('<div class="container-fluid">');
	document.write('<ul class="nav navbar-nav">');
	document.write('<li><a href="index.html">Inicio</a></li>');
	document.write('<li><a href="alumnos.html">CRUD</a></li>');
	document.write('</ul>');
	document.write('</div>');
	document.write('</nav>');
}