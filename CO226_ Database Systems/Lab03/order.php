<html>
 <head>
  <title>Buy T-Shirts Online</title>
 </head>
 <body>
  <h1>Your Order Details</h1>
	<?php
       // $id=$_POST['order_no'];
        $lname=$_POST['lname'];
		$fname=$_POST['fname'];
		$address1=$_POST['address1'];
     $address2=$_POST['address2'];
     $address3=$_POST['address3'];
        $comment=$_POST['comment'];
     $size=$_POST['size'];
     $color=$_POST['color'];
     
     
     if (isset($_POST['cap'])) {
        $cap = "true";   
    } else {
       $cap = "false";
    }
     
     if (isset($_POST['band'])) {
        $band = "true";
    } else {
       $band = "false";
    }
         $db = mysqli_connect('localhost','root','','company')
         or die('Error connecting to MySQL server.');
        $query = "INSERT INTO orders(size,color,cap,wrist_band,firstName,lastName,address1,address2,address3,comment)
                     VALUES ('".$size."','".$color."',".$cap.",".$band.",'".$fname."','".$lname."','".$address1."','".$address2."','".$address3."','".$comment."')";

      // echo $query;
     
       
        mysqli_query($db, $query) or die('Error querying database.');

        $query = "select * from orders where firstName='".$fname."' and lastName='".$lname."'";
    // echo $query."<br>";
     $result = mysqli_query($db,$query)or die('Error querying database.');
     
         $row = mysqli_fetch_assoc($result);
             
         
     
        echo "Thank you <i><b>".$fname."</i></b> for your purchase on our website!<br>";
     
       echo "Your order number is <i><b>".$row['order_number']."</i></b><br>";
     
     echo "Size: <b><i>".$size."</b></i>";
     echo "<br>Color: <b><i>".$color."</b></i>";
     echo "<br>You ordered these extra items: ";
         if (isset($_POST['cap'])) {
            echo "<b><i>Cap </b></i>";
         } 
     if (isset($_POST['band'])) {
         echo "<b><i>Wrist Band</b></i>";
    } 
        
        echo "<br>Your items will be shipped to: <br><i><b>".$address1.",<br>".$address2.",<br>".$address3.".</i></b>";
    
        echo "<br><br>Thank you for submitting your comments! We Appriciate it. You said:<br><br><i><b>".$comment."</b></i>";
         
      mysqli_close($db);
     
	?>
 </body>
</html>
