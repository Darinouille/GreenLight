<?php

include("connexion.php");
try {
    $bd = new PDO ( "mysql:host = $server; dbname=$base", "$user", "$password"); 
    $bd->exec("SET NAMES utf8");
    //echo("Connexion à la base de donnée réussie, bien joué");
}
catch (Exception $e){
    print_r($e -> getMessage());
    die("Erreur de connexion à la base ");
}

$heure0 = $bd ->query("SELECT Heure.pas,Heure.hvalue FROM Jour  LEFT JOIN Heure ON Jour.idJour=Heure.`#idjour` WHERE Jour.idJour=3" );
$monheure0 = ($heure0->fetch(PDO::FETCH_ASSOC));

$montableau = array("pas" => "hvalue");

foreach ($heure0 as $key){
    $montableau[0] = $key['pas'];
    $montableau[1] = $key['hvalue'];
}

print_r($montableau);
echo json_encode($montableau);

?>


