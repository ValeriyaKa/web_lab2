document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("pointForm");
    const mywind = document.getElementById("mywind");
    const Rwind = document.getElementById("Rwind");
    const r = document.querySelectorAll('.r');

    r.forEach(function (checkbox) {
        checkbox.addEventListener("change", function () {
            if (this.checked) {
                r.forEach(function (otherCheckbox) {
                    if (otherCheckbox !== checkbox) {
                        otherCheckbox.checked = false;
                    }
                });
            }
        });
    });


    const RATIO_X = 50;
    const RATIO_Y = 50;
    const CENTER_X = 205;
    const CENTER_Y = 200;
    const graph = document.getElementById("graph-container");

    graph.addEventListener("click", function (event) {
        const selectedR = document.querySelector('.r:checked');
        if (!selectedR) {
            Rwind.style.display = "block"
            return;
        }else {
            Rwind.style.display = "none"
        }
        const rValue = selectedR.value;

        let xPixel = event.offsetX;
        let yPixel = event.offsetY;
        let x = ((xPixel - CENTER_X) / (RATIO_X)).toFixed(1);
        let y = ((CENTER_Y - yPixel) / (RATIO_Y)).toFixed(10);

        sendDataToServer(x, y, rValue);
        drawPoints(xPixel, yPixel, rValue);

        console.log("X:", x, "Y:", y);
        console.log("X:", xPixel, "Y:", yPixel);
    });

    form.addEventListener("submit", function (event) {
        event.preventDefault();

        const x = parseInt(form.elements["x"].value);
        const y = parseFloat(form.elements["y"].value);

        const selectedR = document.querySelector('.r:checked');
        if (!selectedR) {
            Rwind.style.display = "block"
            return;
        }else {
            Rwind.style.display = "none"
        }
        const rValue = selectedR.value;

        const xPixel = CENTER_X + (x * RATIO_X);
        const yPixel = CENTER_Y - (y * RATIO_Y);

        if (!validate(x, y, rValue)) {
            mywind.classList.add("show");
            return false;
        } else {
            mywind.classList.remove("show");
            sendDataToServer(x, y, rValue);
            drawPoints(xPixel, yPixel, rValue);
        }
    });

    function validate(x, y, rValue) {
        return (x >= -3 && x <= 5) && (y >= -3 && y <= 5) && rValue !== null;
    }

    function sendDataToServer(x, y, rValue) {
        const xhr = new XMLHttpRequest();
        xhr.open("POST", '/lab2/ControllerServlet', true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        xhr.send(`x=${x}&y=${y}&r=${rValue}`);
    }
});
