package com.string.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestSortingString {
    public static void main(String[] args) {
        String s = "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0";
        String s1 = "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0"+
                "djsnd982y3r0hc2 qhfqhf9qih2 fi9ehapfy 98hpf28hgp9w8hpf8a hptgu2390tu2a[903tugpa29utgp 2ytgpa832ytgp 28yg pa09 uf[90ua[df9jwef 0iw atj3 'p0irq'-08[t-09q2u t;gauw;gouwog ily942q 98yt4q892 ygqa38hgfv awhfp 8ah;8fthqpdpbav 09ba9u3t;a09u3tf; 0v9a;t9ugfb 09au30t9ugfav ;930ta;2uv 09fua 0923uta0";

        long st = System.currentTimeMillis();
        String sorted2 = sortChar(s,true);
        String sorted3 = sortChar(s1,true);
        System.out.println(System.currentTimeMillis()-st);
        st = System.currentTimeMillis();
        String sorted = sort(s,true);
        String sorted1 = sort(s1,true);
        System.out.println(System.currentTimeMillis()-st);
        System.out.println(sorted2);
    }
    public static String sort(String s,boolean ascending){
        String [] list = s.split("");
        if(ascending){
            Arrays.sort(list);
        } else {
            Arrays.sort(list, (x,y) -> -x.compareTo(y));
        }
        return String.join("",list);
    }
    public static String sortChar(String s, boolean ascending){
        char[] list = s.toCharArray();
        if(ascending){
            Arrays.sort(list);
        } else {
            Arrays.sort(list);
        }
        StringBuilder builder = new StringBuilder(list.length);
        return builder.append(list).toString();
    }
}
