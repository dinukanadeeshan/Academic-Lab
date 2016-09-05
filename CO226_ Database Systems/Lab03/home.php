<html>
    <head><style>
        table, th, td {
    border: 2px solid gray;
    border-collapse: collapse;
}
        
        </style></head>
    <body>
        <table>
            <tr>
                <th >Order Number</th>
                <th>Size</th>
                <th>Color</th>
                <th>Extra Items</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>Comment</th>
            </tr>

<?php
echo "<h1>List of Orders</h1>";
$db = mysqli_connect('localhost','root','','company')
 or die('Error connecting to MySQL server.');

$query = "SELECT * FROM orders";

$result = mysqli_query($db, $query) or die('Error querying database.');

 
	 while ($row = mysqli_fetch_assoc($result)) { 
            echo "<tr>";
         if($row['cap']) $cap = "Cap"; else $cap=NULL;
         if($row['wrist_band']) $band = "Wrist Band"; else $band=NULL;
            echo "<td>".$row['order_number'] . '</td><td>'.$row['size'].'</td><td>'.$row['color'].'</td><td>'.$cap.' '.$band.'</td><td>'. $row['firstName']. '</td><td> ' . $row['lastName']. '</td><td> ' . $row['address1']. ',<br>'. $row['address2'].',<br>'.
                 $row['address3'] .'.</td><td> '. $row['comment'].'</td>';
            echo "</tr>";
        }

mysqli_close($db);

?>
            
               </table>
    </body>  
</html>
