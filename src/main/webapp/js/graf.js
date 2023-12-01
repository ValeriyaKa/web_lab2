function updateGraf(r) {



    // Устанавливаем координаты точек по оси Y
    ['Y1', 'R1'].forEach(id => {
        const el = document.getElementById(id);
        el.setAttribute('y', 50 * 3 / r);
        el.textContent = r;
    });
    ['-X1', '-R'].forEach(id => {
        const el = document.getElementById(id);
        el.setAttribute('x', 50 * 3 / r);
        el.textContent = r;

    });

    ['-Y1', '-R1/2'].forEach(id => {
        const el = document.getElementById(id);
        el.setAttribute('y', ((285 - 200) * r / 3) + 200);
        el.textContent = r/2;

    });
    [ '-Y2', '-R1' ].forEach(id => {
        const el = document.getElementById(id);
        el.setAttribute('y', ((370 - 200) * r / 3) + 200);
        el.textContent = r;

    });

    // Устанавливаем координаты точек по оси X
    ['-X2', '-R/2'].forEach(id => {
        const el = document.getElementById(id);
        el.setAttribute('x', 200 - ((200 - 115) * r / 3));
        el.textContent = r/2;

    });
    [ 'Y2','R1/2' ].forEach(id => {
        const el = document.getElementById(id);
        el.setAttribute('y', 200 - ((200 - 125) * r / 3));
        el.textContent = r/2;

    });

    ['X1', 'R/2'].forEach(id => {
        const el = document.getElementById(id);
        el.setAttribute('x', ((285 - 200) * r / 3) + 200);
        el.textContent = r/2;


    });

    ['X2', 'R'].forEach(id => {
        const el = document.getElementById(id);
        el.setAttribute('x', ((370 - 200) * r / 3) + 200);
        el.textContent = r;


    });

    // Обновляем координаты фигур
    const circle = document.getElementById('circle');
    const startRadius = ((3 - r) / 0.5) * 12;
    circle.setAttribute('d', `M 200.5 200 L 200.5 ${120 + startRadius} A ${73+3*startRadius/12} ${73+3*startRadius/12} 0 0 1 ${285 - startRadius} 200 Z`);

    const square = document.getElementById('square');
    square.setAttribute('width', (85 / 3) * r);
    square.setAttribute('height', (170 / 3) * r);
    square.setAttribute('x', 200.5);
    square.setAttribute('y', 200.5);

    const triangle = document.getElementById('triangle');
    triangle.setAttribute('points', `${200 - (52 * r)},200 200,200 198,${205 + (55 * r)}`);


}



function drawPoints(x, y, rValue) {

    // Создание элемента точки
    let circle = document.createElementNS('http://www.w3.org/2000/svg', 'circle');

    circle.setAttribute('cx', x);
    circle.setAttribute('cy', y);

    // Устанавливаем радиус точки
    circle.setAttribute('r', 4);

    // Устанавливаем цвет точки
    const colors = {
        1: '#81a7d6',
        2: '#fc3f00',
        3: '#368f5f',
        1.5: '#decc60',
        2.5: '#ff4375'
    };

    circle.setAttribute('fill', colors[rValue] || 'black');

    // Устанавливаем уникальный идентификатор точки
    circle.setAttribute('id', `myCircle_${Math.random().toString(36).substr(2, 9)}`);

    // Добавляем точку на SVG график
    const svg = document.getElementById('mySVG');
    svg.appendChild(circle);
}
