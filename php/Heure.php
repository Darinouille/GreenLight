<?php

include("connexion.php");

// Les données heures du jour 0
$sql = "SELECT Heure.pas, Heure.hvalue FROM Jour LEFT JOIN Heure ON Jour.idJour=Heure.`#idjour` WHERE Jour.idJour=0";
$req = $bd ->prepare($sql);
$req->execute();
$heures0 = $req->fetchall();
$req->closeCursor();

$hjour0 = array("pas" => "hvalue");
foreach($heures0 as $h) {
  $pas = $h['pas'];
  $hvalue = $h['hvalue'];
  $hjour0[$pas] = $hvalue;
}


// Les données heures du jour 1
$sql = "SELECT Heure.pas, Heure.hvalue FROM Jour LEFT JOIN Heure ON Jour.idJour=Heure.`#idjour` WHERE Jour.idJour=1";
$req = $bd ->prepare($sql);
$req->execute();
$heures1 = $req->fetchall();
$req->closeCursor();

$hjour1 = array("pas" => "hvalue");
foreach($heures1 as $h) {
  $pas = $h['pas'];
  $hvalue = $h['hvalue'];
  $hjour1[$pas] = $hvalue;
}


// Les données heures du jour 2
$sql = "SELECT Heure.pas, Heure.hvalue FROM Jour LEFT JOIN Heure ON Jour.idJour=Heure.`#idjour` WHERE Jour.idJour=2";
$req = $bd ->prepare($sql);
$req->execute();
$heures2 = $req->fetchall();
$req->closeCursor();

$hjour2 = array("pas" => "hvalue");
foreach($heures2 as $h) {
  $pas = $h['pas'];
  $hvalue = $h['hvalue'];
  $hjour2[$pas] = $hvalue;
}


// Les données heures du jour 3
$sql = "SELECT Heure.pas, Heure.hvalue FROM Jour LEFT JOIN Heure ON Jour.idJour=Heure.`#idjour` WHERE Jour.idJour=3";
$req = $bd ->prepare($sql);
$req->execute();
$heures3 = $req->fetchall();
$req->closeCursor();

$hjour3 = array("pas" => "hvalue");
foreach($heures3 as $h) {
  $pas = $h['pas'];
  $hvalue = $h['hvalue'];
  $hjour3[$pas] = $hvalue;
}


// Mise en forme des informations
$tableau = array(
  "Jour0" => $hjour0,
  "Jour1" => $hjour1,
  "Jour2" => $hjour2,
  "Jour3" => $hjour3);

// Transformation en json
echo json_encode($tableau);
?>

