package net.patrick.create_metal_industries.item.tool;

import java.util.HashMap;
import java.util.Map;

public interface CMIWorldLayers
{
    Map<Integer, Integer> layerMaxYMap = createLayerMaxYMap();
    Map<Integer, Integer> layerMinYMap = createLayerMinYMap();
    Map<Integer, Integer> yToLayerMap = createYToLayerMap();
    
    static Map<Integer, Integer> createLayerMaxYMap()
    {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(8, 16);
        map.put(7, 32);
        map.put(6, 48);
        map.put(5, 64);
        map.put(4, 80);
        map.put(3, 96);
        map.put(2, 112);
        map.put(1, 128);
        return Map.copyOf(map); // Makes it immutable
    }
    
    static Map<Integer, Integer> createLayerMinYMap()
    {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(8, 0);
        map.put(7, 17);
        map.put(6, 33);
        map.put(5, 49);
        map.put(4, 65);
        map.put(3, 81);
        map.put(2, 97);
        map.put(1, 113);

        return Map.copyOf(map); // Makes it immutable
    }
    
    static Map<Integer, Integer> createYToLayerMap()
    {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 8);
        map.put(1, 8);
        map.put(2, 8);
        map.put(3, 8);
        map.put(4, 8);
        map.put(5, 8);
        map.put(6, 8);
        map.put(7, 8);
        map.put(8, 8);
        map.put(9, 8);
        map.put(10, 8);
        map.put(11, 8);
        map.put(12, 8);
        map.put(13, 8);
        map.put(14, 8);
        map.put(15, 8);
        map.put(16, 8);
        map.put(17, 7);
        map.put(18, 7);
        map.put(19, 7);
        map.put(20, 7);
        map.put(21, 7);
        map.put(22, 7);
        map.put(23, 7);
        map.put(24, 7);
        map.put(25, 7);
        map.put(26, 7);
        map.put(27, 7);
        map.put(28, 7);
        map.put(29, 7);
        map.put(30, 7);
        map.put(31, 7);
        map.put(32, 7);
        map.put(33, 6);
        map.put(34, 6);
        map.put(35, 6);
        map.put(36, 6);
        map.put(37, 6);
        map.put(38, 6);
        map.put(39, 6);
        map.put(40, 6);
        map.put(41, 6);
        map.put(42, 6);
        map.put(43, 6);
        map.put(44, 6);
        map.put(45, 6);
        map.put(46, 6);
        map.put(47, 6);
        map.put(48, 6);
        map.put(49, 5);
        map.put(50, 5);
        map.put(51, 5);
        map.put(52, 5);
        map.put(53, 5);
        map.put(54, 5);
        map.put(55, 5);
        map.put(56, 5);
        map.put(57, 5);
        map.put(58, 5);
        map.put(59, 5);
        map.put(60, 5);
        map.put(61, 5);
        map.put(62, 5);
        map.put(63, 5);
        map.put(64, 5);
        map.put(65, 4);
        map.put(66, 4);
        map.put(67, 4);
        map.put(68, 4);
        map.put(69, 4);
        map.put(70, 4);
        map.put(71, 4);
        map.put(72, 4);
        map.put(73, 4);
        map.put(74, 4);
        map.put(75, 4);
        map.put(76, 4);
        map.put(77, 4);
        map.put(78, 4);
        map.put(79, 4);
        map.put(80, 4);
        map.put(81, 3);
        map.put(82, 3);
        map.put(83, 3);
        map.put(84, 3);
        map.put(85, 3);
        map.put(86, 3);
        map.put(87, 3);
        map.put(88, 3);
        map.put(89, 3);
        map.put(90, 3);
        map.put(91, 3);
        map.put(92, 3);
        map.put(93, 3);
        map.put(94, 3);
        map.put(95, 3);
        map.put(96, 3);
        map.put(97, 2);
        map.put(98, 2);
        map.put(99, 2);
        map.put(100, 2);
        map.put(101, 2);
        map.put(102, 2);
        map.put(103, 2);
        map.put(104, 2);
        map.put(105, 2);
        map.put(106, 2);
        map.put(107, 2);
        map.put(108, 2);
        map.put(109, 2);
        map.put(110, 2);
        map.put(111, 2);
        map.put(112, 2);
        map.put(113, 1);
        map.put(114, 1);
        map.put(115, 1);
        map.put(116, 1);
        map.put(117, 1);
        map.put(118, 1);
        map.put(119, 1);
        map.put(120, 1);
        map.put(121, 1);
        map.put(122, 1);
        map.put(123, 1);
        map.put(124, 1);
        map.put(125, 1);
        map.put(126, 1);
        map.put(127, 1);
        map.put(128, 1);
        return Map.copyOf(map); // Makes it immutable
    }
}
