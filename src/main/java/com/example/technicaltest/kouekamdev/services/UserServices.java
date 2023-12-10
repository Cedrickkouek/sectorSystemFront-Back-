package com.example.technicaltest.kouekamdev.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Stream;

import com.example.technicaltest.kouekamdev.entities.User;
import com.example.technicaltest.kouekamdev.exceptions.SectorNotFoundException;
import com.example.technicaltest.kouekamdev.exceptions.UserNotFoundeException;
import com.example.technicaltest.kouekamdev.payloads.UserEditPayload;
import com.example.technicaltest.kouekamdev.payloads.UserPayload;
import com.example.technicaltest.kouekamdev.repositories.SectorsRepositories;
import com.example.technicaltest.kouekamdev.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServices {
    
    @Autowired
    private final UserRepository userRepository;
    private final SectorsRepositories sectorsRepositories;
    //private SectorsServices sectorsServices;

    public User CreateUser(UserPayload userPayload) throws SectorNotFoundException
    {
        System.out.println(userPayload);
        System.out.println(userPayload);
        System.out.println(userPayload);
        //var allSectors = sectorsServices.GetAllSectors();
        //boolean containsValue =  allSectors.contains(userPayload.getSector());
        if (sectorsRepositories.existsByValue(userPayload.getSector())) {
            User user = User.builder()
            .agreeTerms(true)
            .name(userPayload.getName())
            .sectors(userPayload.getSector()).build();
            
            return userRepository.save(user);
        }
        else
        {
            throw new SectorNotFoundException(userPayload.getSector()+" "+"Sector not found");
        }
    }

    public User EditUser(UserEditPayload userEditPayload) throws SectorNotFoundException, UserNotFoundeException
    {
            System.out.println(userEditPayload);
            System.out.println(userEditPayload);
            System.out.println(userEditPayload);
        User user = userRepository.findByName(userEditPayload.getOldName());
        boolean checkUser = userRepository.existsByName(userEditPayload.getOldName());
        if (checkUser) {
            if(userEditPayload.getNewName().isEmpty())
            {
                if(userEditPayload.getSector().isEmpty())
                {

                }
                else
                {
                    if(sectorsRepositories.existsByValue(userEditPayload.getSector()))
                    {
                        user.setSectors(userEditPayload.getSector());
                        userRepository.save(user);
                    }
                    else
                    {
                        throw new SectorNotFoundException("The sector "+userEditPayload.getSector()+" doesn't exist!");
                    }
                    
                }
            }
            else
            {
                user.setName(userEditPayload.getNewName());
                userRepository.save(user);
            }
            return user;
        }
        else
        {
            throw new UserNotFoundeException("User "+userEditPayload.getOldName()+" not found!");
        }
    }

    public void DeleteUser(String name)
    {
        userRepository.deleteByName(name);
    }
}
