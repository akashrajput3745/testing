function ajax() {
    var demo = document.getElementById("demo");
    let str = document.getElementById("str").value;
    var xhttp = new XMLHttpRequest()
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("demo").innerHTML = this.responseText;
            console.log(this.responseText)

        }
    }
    xhttp.open("POST", "server2.php", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")

    xhttp.send("str="+str);
}
