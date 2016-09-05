<html>
    <head><title>Search Order Results</title>
        <style>
        table, th, td {
    border: 2px solid gray;
    border-collapse: collapse;
}
        
        </style></head>
    <body>
        <table>
            <tr>
                <th>Order Number</th>
                <th>Size</th>
                <th>Color</th>
                <th>Extra Items</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>Comment</th>
            </tr>
<?php
            
    $orderNo = $_POST['search'];

    $db = mysqli_connect('localhost','root','','company')
         or die('Error connecting to MySQL server.');

    $query = "select * from orders where order_number='".$orderNo."'";

    $result = mysqli_query($db, $query) or die('Error querying database.');

    if (mysqli_num_rows($result) > 0) {
        while ($row = mysqli_fetch_assoc($result)) { 
              echo "<tr>";
         if($row['cap']) $cap = "Cap"; else $cap=NULL;
         if($row['wrist_band']) $band = "Wrist Band"; else $band=NULL;
            echo "<td>".$row['order_number'] . '</td><td>'.$row['size'].'</td><td>'.$row['color'].'</td><td>'.$cap.' '.$band.'</td><td>'. $row['firstName']. '</td><td> ' . $row['lastName']. '</td><td> ' . $row['address1']. ',<br>'. $row['address2'].',<br>'.
                 $row['address3'] .'.</td><td> '. $row['comment'].'</td>';
            echo "</tr>";
        }
    }else{
        echo    "No result found for ".$orderNo;
    }
    mysqli_close($db);
    
?>
        </table>
    </body>  
</html>