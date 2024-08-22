package org.example.eksamenii.services;
import org.example.eksamenii.models.Track;
import org.example.eksamenii.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    public Track getTrackById(int id) {
        return trackRepository.findById(id).orElse(null);
    }

    public Track createTrack(Track track) {
        return trackRepository.save(track);
    }

    public Track updateTrack(int id, Track trackDetails) {
        Track track = getTrackById(id);
        if (track != null) {
            track.setType(trackDetails.getType());
            track.setShape(trackDetails.getShape());
            track.setSurface(trackDetails.getSurface());
            track.setLength(trackDetails.getLength());
            track.setLanes(trackDetails.getLanes());
            return trackRepository.save(track);
        }
        return null;
    }

    public void deleteTrack(int id) {
        trackRepository.deleteById(id);
    }
}
