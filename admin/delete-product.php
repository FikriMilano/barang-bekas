<?php
    require_once "../helper/conn.php";
    require_once "../helper/auth.php";

    $id = $_GET["id"];
    //mengambil id yang ingin dihapus


    $apakahada = "SELECT * FROM product WHERE id='$id'";
    $result = mysqli_query($conn, $apakahada);

    $data = mysqli_fetch_assoc($result);

    $res=mysqli_query($conn,"SELECT * from product WHERE id=$id limit 1");

    if($row=mysqli_fetch_assoc($res)) 
    {
        $deleteimage=$row['image']; 
    }
    unlink("../assets/img/".$deleteimage);

    //jalankan query DELETE untuk menghapus data
    $query = "DELETE FROM product WHERE id='$id'";
    $hasil_query = mysqli_query($conn, $query);

    //periksa query, apakah ada kesalahan

    if(!$data) {
    echo "<script>alert('Access Denied!');window.location='/admin/index.php';</script>";
    } else {
    echo "<script>alert('Produk berhasil dihapus.');window.location='/admin/index.php';</script>";
    }