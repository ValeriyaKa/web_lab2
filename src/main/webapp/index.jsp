<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Web lab_2</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="style.css">
    <script src="js/script.js" charset="UTF-8"></script>
    <script src="js/graf.js" charset="UTF-8"></script>
    <meta name="theme-color" content="#fafafa">
</head>
<body>

<header>
    Валявина Валерия Константиновна P3223
    <br/> Вариант: 285216
</header>

<div id="containers">
    <div id="graph-container">
        <svg id="mySVG" width="410" height="400" xmlns="http://www.w3.org/2000/svg">
            <!-- Ось X -->
            <line x1="30" y1="200" x2="395" y2="200" stroke="black" stroke-width="1"/>
            <polygon points="395,200 385,205 385,195" fill="black"/>

            <!-- Ось Y -->
            <line x1="200" y1="30" x2="200" y2="420" stroke="black" stroke-width="1"/>
            <polygon points="200,30 205,40 195,40" fill="black"/>

            <!-- Подписи для осей -->
            <text x="395" y="195" font-size="12" fill="black">X</text>
            <text x="205" y="30" font-size="12" fill="black">Y</text>

            <!-- Точки на графике по оси X -->
            <rect id="-X1" x="50" y="195" width="1" height="11" fill="black"/>
            <rect id="-X2" x="125" y="195" width="1" height="11" fill="black"/>
            <rect id="X1" x="285" y="195" width="1" height="11" fill="black"/>
            <rect id="X2" x="370" y="195" width="1" height="11" fill="black"/>

            <!-- Точки на графике по оси Y -->
            <rect id="Y1" x="195" y="50" width="11" height="1" fill="black"/>
            <rect id="Y2" x="195" y="125" width="11" height="1" fill="black"/>
            <rect id="-Y1" x="195" y="285" width="11" height="1" fill="black"/>
            <rect id="-Y2" x="195" y="370" width="11" height="1" fill="black"/>

            <!-- Подписи для точек X -->
            <text id="-R" x="45" y="210" font-size="10" fill="black">-R</text>
            <text id="-R/2" x="140" y="210" font-size="10" fill="black">-R/2</text>
            <text id="R/2" x="290" y="210" font-size="10" fill="black">R/2</text>
            <text id="R" x="385" y="210" font-size="10" fill="black">R</text>

            <!-- Подписи для точек Y -->
            <text id="R1" x="205" y="45" font-size="10" fill="black">R</text>
            <text id="R1/2" x="205" y="120" font-size="10" fill="black">R/2</text>
            <text id="-R1/2" x="205" y="275" font-size="10" fill="black">-R/2</text>
            <text id="-R1" x="205" y="366" font-size="10" fill="black">-R</text>

            <!-- Круг (Фигура_1) -->
            <path id="circle" d="M200.5 200 L200.5 120 A75 70 0 0 1 285 200 Z" fill="#867edc"/>

            <!-- Квадрат (Фигура_квадрат) -->
            <rect id="square" x="200.5" y="200.5" width="85" height="170"  fill="#867edc"/>

            <!-- Треугольник (Фигура_треугольник) -->
            <polygon id="triangle" points="45,200 200,200 198,370"  fill="#867edc"/>
        </svg>
    </div>

    <div id="coordinates-container">
        <form id="pointForm" action="ControllerServlet" method="post">
            <br>
            <label for="x">X:</label>
            <select id="x" name="x" required>
                <option value="-3">-3</option>
                <option value="-2">-2</option>
                <option value="-1">-1</option>
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>
            <br>
            <label for="y">Y:</label>
            <input type="text" id="y" name="y" placeholder="[-3; 5]" required pattern="^-?\d+(\.\d+)?$">
            <br>
            <label>R:</label>
            <input type="checkbox" class="r" id="r1" name="1" value="1"> 1 </input>
            <input type="checkbox" class="r" id="r2" name="1.5" value="1.5"> 1.5 </input>
            <input type="checkbox" class="r" id="r3" name="2" value="2"> 2 </input>
            <input type="checkbox" class="r" id="r4" name="2.5" value="2.5"> 2.5 </input>
            <input type="checkbox" class="r" id="r5" name="3" value="3"> 3 </input>
            <br>
            <span class="wind" id="Rwind">Пожалуйста, выберите значение R.</span>
            <div class="button">
                <button type="submit">Проверить</button>
                <span class="wind" id="mywind">Пожалуйста, введите корректные числовые значения для X, Y и R.</span>
            </div>
        </form>
    </div>
</div>
<a href="result.jsp" target="_blank">Перейти на страницу результатов</a>
<div id="error-container"></div>

</body>
</html>
