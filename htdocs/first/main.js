var demo = document.getElementById("area")
async function fatc() {
    let ip1 = document.getElementById('ip1').value
    let ip2 = document.getElementById('ip2').value
    let data = {
        input1: ip1,
        input2: ip2
    }
    await fetch("test.php", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
        .then((r) => r.json())
        .then((txt) => {
            console.log(txt)
            for (const data in txt) {
                // if (Object.prototype.hasOwnProperty.call(object, data)) {
                demo.innerHTML += `<br>${data}</br>`

                // }
            }
        })

}