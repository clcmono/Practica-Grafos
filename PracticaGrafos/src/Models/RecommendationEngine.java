package Models;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import Controllers.Graph;
import Models.User;


public class RecommendationEngine {
    public List <User> recommendFriends (NodeGraph<User> node, Graph<User> graph){ 
        List <User> recommendations = new ArrayList<>();
        for (NodeGraph <User> potentialFriendNode : graph.getNodes()){
            User potentialFriend = potentialFriendNode.getUser();
            if (!node.getFriends().contains(potentialFriend)&& !node.getUser().equals(potentialFriend)){
                double similarity = calculateSimilarity(node.getUser(), potentialFriend);
                if (similarity > 0.5){ //Umbral para recomendacion
                    recommendations.add(potentialFriend);
                }
            }
        }
        return recommendations;
    }

    public double calculateSimilarity( User user1, User user2){
        Set<String> interest1 = new HashSet<>(user1.getInterests());
        Set<String> interest2 = new HashSet<>(user2.getInterests());
        Set<String> intersection = new HashSet<>(interest1);
        intersection.retainAll(interest2);
        Set<String> union = new HashSet<>(interest1);
        union.addAll(interest2);

        double resp = (double) intersection.size()/ union.size();
        System.out.println("Valor - " + resp);
        return resp;

    }




    
}

