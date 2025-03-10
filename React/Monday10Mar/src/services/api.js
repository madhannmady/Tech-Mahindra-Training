import axios from "axios";

const api = {
  getCourses: async () => {
    try {
      const response = await axios.get("/src/assets/api.json");
      return response.data;
    } catch (error) {
      console.error("Error fetching courses:", error);
      return [];
    }
  },
};

export default api;
