<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
    /* Table styles that match the form/card look */
    .data-card{
        margin-top:18px;
        width:100%;
        max-width:760px;
    }

    .students-table {
        width:100%;
        border-collapse:collapse;
        margin-top:8px;
        font-size:14px;
    }

    .students-table thead th{
        text-align:left;
        font-weight:600;
        font-size:13px;
        color:var(--muted);
        padding:12px;
        background: linear-gradient(180deg, rgba(255,255,255,0.01), transparent);
        border-bottom:1px solid rgba(255,255,255,0.04);
    }

    .students-table tbody td{
        padding:12px;
        border-bottom:1px solid rgba(255,255,255,0.03);
        vertical-align:middle;
    }

    .students-table tbody tr:hover{
        background: linear-gradient(90deg, rgba(99,102,241,0.03), rgba(110,231,183,0.02));
    }

    .students-table .id{
        font-variant-numeric: tabular-nums;
        color:#dffcf0;
        width:140px;
    }

    .students-table .name{
        font-weight:600;
    }

    .students-table .class{
        color:var(--muted);
        width:180px;
    }

    .student-actions{
        display:flex;
        gap:8px;
        justify-content:flex-end;
    }

    /* smaller button variants that reuse existing classes */
    .primary.sm{
        padding:6px 10px;
        border-radius:8px;
        font-size:13px;
        box-shadow: 0 6px 18px rgba(99,102,241,0.08);
    }
    .ghost.sm{
        padding:6px 10px;
        border-radius:8px;
        font-size:13px;
    }

    @media (max-width:640px){
        .students-table thead th:nth-child(4),
        .students-table tbody td:nth-child(4){
            display:none;
        }
    }
</style>
</head>
<body>
    
</body>
</html>
<?php
echo "
<div class='card data-card' role='region' aria-labelledby='tableTitle'>
    <div class='panel'>
        <div style='display:flex;align-items:center;justify-content:space-between;gap:12px;margin-bottom:12px;'>
            <div>
                <h1 id='tableTitle' style='font-size:16px;margin:0'>Registered Students</h1>
                <p class='lead' style='margin:6px 0 0'>Recent records — ID, full name and class.</p>
            </div>
        </div>

        <div style='overflow:auto'>
            <table class='students-table' role='table' aria-labelledby='tableTitle'>
                <thead>
                    <tr>
                        <th scope='col'>Student ID</th>
                        <th scope='col'>Full Name</th>
                        <th scope='col'>Class</th>
                        <th scope='col' style='text-align:right'>Actions</th>
                    </tr>
                </thead>
                <tbody>";
?>